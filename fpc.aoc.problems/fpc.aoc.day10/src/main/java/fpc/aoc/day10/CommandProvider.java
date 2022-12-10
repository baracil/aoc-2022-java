package fpc.aoc.day10;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class CommandProvider {

  private final @NonNull ImmutableList<Command> commands;

  private int commandIndex = 0;

  public @NonNull Optional<Command> takeCommand() {
    if (commandIndex>= commands.size()) {
      return Optional.empty();
    }
    return Optional.ofNullable(commands.get(commandIndex++));
  }

}
