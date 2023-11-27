
package ttknpdev.log;

import org.apache.log4j.Logger;
import ttknpdev.connection.ConnectDatabase;
import ttknpdev.gui.tabel_reads.ShowToys;
import ttknpdev.service.ToyService;

public interface MyLog {
   Logger connecttion = Logger.getLogger(ConnectDatabase.class);
   Logger toyService = Logger.getLogger(ToyService.class);
   Logger showToys = Logger.getLogger(ShowToys.class);
}
