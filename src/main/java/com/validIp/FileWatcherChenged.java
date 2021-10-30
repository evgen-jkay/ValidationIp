package com.validIp;

/**
 * Поток который мониторит на лету изменения в файле
 *
 * @author      Eugen Landarenko
 * @version     1.0
 * @link        https://github.com/evgen-jkay/ValidationIp
 */

import java.io.IOException;
import java.nio.file.*;

public class FileWatcherChenged extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            fileWatcher();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void fileWatcher() throws IOException, InterruptedException {
        final Path path = Paths.get(ValidationIp.PATH_DIR);
        try (final WatchService watchService = FileSystems.getDefault().newWatchService()) {
            final WatchKey watchKey = path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
            while (true) {
                final WatchKey wk = watchService.take();
                wk.reset();
            }
        }
    }

}
