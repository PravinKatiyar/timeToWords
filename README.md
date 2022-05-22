#Speaking Clock

# Kindly find output images in the repository for better understanding.
# convert Current time to words (24 Hours Format)
# convert user input time to words (24 Hours Format)
# port number is 8081
# DateTime API, REGEX , REST API, MAVEN is used in the project

# Test 01:
Post
  http://localhost:8081/api/time
#  body:
    {
	    "time":"14:40"
    }
#   o/p: 
    It's fourteen fourty
    
# Test 02:
  Get:
  http://localhost:8081/api/time
#  o/p: 
    Says current time in words**



