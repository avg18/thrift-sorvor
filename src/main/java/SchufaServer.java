

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TSSLTransportFactory;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TSSLTransportFactory.TSSLTransportParameters;

// Generated code
import de.*;
import de.hska.iwi.avg.schufasystem.service.SchufaService.SchufaService;
import de.hska.iwi.avg.schufasystem.service.SchufaService.SchufaService.Processor;

import java.util.HashMap;

public class SchufaServer {

  public static SchufaHandler handler;

  public static Processor processor;

  public static void main(String [] args) {
    try {
      handler = new SchufaHandler();
      processor = new Processor(handler);

      Runnable simple = new Runnable() {
        public void run() {
          simple(processor);
        }
      };      

      new Thread(simple).start();
    } catch (Exception x) {
      x.printStackTrace();
    }
  }

  public static void simple(Processor processor) {
    try {
      TServerTransport serverTransport = new TServerSocket(9090);
      TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));

      // Use this for a multithreaded server
      // TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));

      System.out.println("Starting the simple Schufa server...");
      server.serve();
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
}
  
