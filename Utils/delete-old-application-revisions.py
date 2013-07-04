import httplib
import simplejson
import base64


# set  configs
host_and_port = "api.enterprise.apigee.com" 
username="your_username" # Replace
org_name="test-4g" # Replace with your org name
password="your_password" # Replace
inactive_revisions_to_keep = 3  # including the active revisions

connection = httplib.HTTPSConnection(host_and_port, timeout=30, strict=0 )


# get all apps
headers = {"Accept": "application/json", "Authorization": "Basic "+base64.b64encode(username+':'+password)}
connection.request('GET', '/v1/organizations/'+org_name+'/apis/', '', headers)

resp = connection.getresponse()

if (resp.status >= 200):
	apps = simplejson.loads(resp.read())
	print apps
else:
	print "request to retrieve the applications failed."
	print str(resp.status)+" "+resp.reason
	print resp.read()
	

# get active deployment revisions
if (len(apps) > 0):

	for i in range(0, len(apps)):
		connection.request('GET', '/v1/organizations/'+org_name+'/apis/'+apps[i]+'/deployments', '', headers)
		resp = connection.getresponse()
		revisions = simplejson.loads(resp.read()) #   esp.read().encode('ascii', 'ignore')
		if (resp.status >= 200 and len(revisions['environment'])>0):
			#print resp.read()
			# print "revisions ************** = "+str(revisions)
			# print "revisions 0 ************** = "+str(revisions['environment'][0])
			# print "revisions 1 ************** = "+str(revisions['environment'][1])


			active_revisions_to_keep = []

			active_deployment_revision =int(revisions['environment'][0]['revision'][0]['name']) 

			for j in range(0, len(revisions['environment'])):
				active_revisions_to_keep.append(int(revisions['environment'][j]['revision'][0]['name']))
				if (int(revisions['environment'][j]['revision'][0]['name'])>active_deployment_revision):
					active_deployment_revision = int(revisions['environment'][j]['revision'][0]['name'])
				for k in range(1, inactive_revisions_to_keep):
					active_revisions_to_keep.append(int(revisions['environment'][j]['revision'][0]['name'])-k)

			# Now delete the inactive revisions for the app
			revisions_to_keep = set(active_revisions_to_keep) 

			for l in range (1, active_deployment_revision+1):
				if l not in revisions_to_keep:
					try:
						connection.request('DELETE', '/v1/organizations/'+org_name+'/apis/'+apps[i]+'/revisions/'+str(l), '', headers)
						resp = connection.getresponse()
						print "*************************************** Deleting revision " +str(l) +" of Application "+apps[i]+" ***************************************"
						if (resp.status >= 200):
							#print resp.read()
							revisions = simplejson.loads(resp.read()) #   esp.read().encode('ascii', 'ignore')
							print revisions
						else:
							print "request to retrieve the application revisions failed for "+apps[i]+" application"
							print str(resp.status)+" "+resp.reason
							print resp.read()
					except Exception, e:
						print e
						pass
				else:
					print "*************************************** Keeping revision " +str(l) +" of Application "+apps[i]+" ***************************************"

		else:
			print "No deployments found for "+apps[i]+" application"
			print str(resp.status)+" "+resp.reason
			print resp.read()

