package fpc.aoc.day7;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@RequiredArgsConstructor
public class FileSystem {

  private final @NonNull File.Folder root;
  private final int diskSize = 70000000;

  public Stream<File.Folder> streamDirectories() {
    return Stream.concat(Stream.of(root), root.streamDirectories());
  }

  public int getFreeSpace() {
    return diskSize - root.size();
  }
}
