package co.edu.unisabana.examplek8s;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MemoryConsume {

  public void consume(int megabytesToConsume) {
    try {
      int bytesPerMegabyte = 1024 * 1024;
      long bytesToAllocate = (long) megabytesToConsume * bytesPerMegabyte;

      // Crear una lista para almacenar objetos y consumir memoria
      List<byte[]> memoryConsumingList = new ArrayList<>();

      while (bytesToAllocate > 0) {
        // Crear un nuevo array de bytes y agregarlo a la lista
        int chunkSize = (int) Math.min(bytesToAllocate, Integer.MAX_VALUE);
        byte[] memoryChunk = new byte[chunkSize];
        memoryConsumingList.add(memoryChunk);

        bytesToAllocate -= chunkSize;
      }

      System.out.println("Consumiendo " + megabytesToConsume + " MB de memoria RAM.");
    } catch (OutOfMemoryError e) {
      // Manejar la excepción si se agota la memoria
      e.printStackTrace();
      throw e;
    }
  }
}
