package fpc.aoc.common;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;

@RequiredArgsConstructor
public class ProxyArrayOfChar implements ArrayOfChar {

  @Delegate
  private final @NonNull ArrayOfChar delegate;
}
