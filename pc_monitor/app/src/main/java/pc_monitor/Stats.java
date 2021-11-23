package pc_monitor;

import picocli.CommandLine.Command;
import java.util.concurrent.Callable;
import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;
import java.io.*;

@Command(name = "Stats")
public class Stats implements Callable<Integer> {

    @Command(name = "ram")
    public Integer Ram() {
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
        double totalMemorySize = operatingSystemMXBean.getTotalMemorySize() / Math.pow(1024, 3);
        double usedMemorySize = (operatingSystemMXBean.getTotalMemorySize() - operatingSystemMXBean.getFreeMemorySize())
                / Math.pow(1024, 3);

        System.out.println("Total memory: " + totalMemorySize + " GB");
        System.out.println("Used memory: " + usedMemorySize + " GB");

        return 0;
    }

    @Command(name = "hd")
    public Integer HD() {
        double totalDiskSize = new File("/").getTotalSpace() / Math.pow(1024, 3);
        double usedDiskSize = new File("/").getTotalSpace() - new File("/").getFreeSpace() / Math.pow(1024, 3);

        System.out.println("Total disk space: " + totalDiskSize + " GB");
        System.out.println("Used disk space: " + usedDiskSize + " GB");

        return 0;
    }

    @Command(name = "cpu")
    public Integer CPU() {
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
        double cpuLoad = operatingSystemMXBean.getCpuLoad();

        System.out.println("CPU Load: " + cpuLoad);

        return 0;
    }

    @Command(name = "email")
    public Integer Email() {
        Log log = new Log();
        try {
            Alert alert = new Alert();
            alert.sendEmail();
            
            log.info("User sent an e-mail.");
            return 0;
        } catch (Exception e) {
            log.error("User failed to send an email.", e);
            return 1;
        }
    }

    public Integer call() throws Exception {
        System.out.println("I'm working!");

        return 0;
    }
}
