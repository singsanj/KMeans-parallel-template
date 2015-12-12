import predictionio
import numpy as np
client = predictionio.EventClient(
    access_key='39RE6DgOxEUus61XYf86y2shq7n4e78Xm7N5bXhiFj0bmJkNTQEiLfiqpDBaz8TK',
    url='http://localhost:7070',
    threads=5,
    qsize=500
)

data = np.genfromtxt("../data/test.txt", delimiter = "\t")
num = data.shape[0]
# Set the 4 properties for a user
for i in range(0,num):
	client.create_event(
    	event="$set",
    	entity_type="point",
    	entity_id=i,
    	properties= {
      	"attr0" : data[i][0],
      	"attr1" : data[i][1],
      	"plan" : data[i][2]
    	}
	)
	print(i)
