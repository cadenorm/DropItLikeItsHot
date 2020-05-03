
import socket
import random




def give_highscore()-> int:
    return str(random.randint(10000, 5000000))

def game_over() -> str:
    score = random.randint(0, 10000)
    ret = "GAME OVER! You scored: " + str(score)
    return ret

def parse_service_request(request: str):
    if(request == 'req_highscore'):
        return give_highscore()
    elif (request == 'req_gameover'):
        return game_over()
    else:
        print("Did not recognize service request")
        exit(-1)

# set up server listener
listensocket = socket.socket()
Port = 8000
maxConnections = 999
IP = socket.gethostname()  # get hostname of current machine

listensocket.bind(('', Port))

# start server
listensocket.listen(maxConnections)
print("Server started at " + IP + " on port " + str(Port))

# accepts incoming connection
(clientsocket, address) = listensocket.accept()

# open file


# receive image
while 1:
    # writes data to file
    data = clientsocket.recv(1024).decode()  # get incoming data
    request_back = parse_service_request(data)
    clientsocket.send(request_back.encode())


# close socket
clientsocket.close()
# clientsocket.close()
listensocket.close()
