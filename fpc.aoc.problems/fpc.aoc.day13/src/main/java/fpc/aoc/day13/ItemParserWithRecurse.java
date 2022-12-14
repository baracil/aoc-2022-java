package fpc.aoc.day13;

import com.google.common.collect.ImmutableList;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemParserWithRecurse {

  public static Item parse(String line) {
    return new ItemParserWithRecurse(line).parse();
  }


  //invariant line is a int or the full content of a list without the []
  private final @NonNull String line;

  private Item parse() {
    if (!line.startsWith("[")) {
      return new Item.Scalar(Integer.parseInt(line));
    }
    if (line.equals("[]")) {
      return new Item.List(ImmutableList.of());
    }
    int idx = 0;
    final var builder = ImmutableList.<Item>builder();
    while (idx < line.length()) {
      final int end = findNextSeparator(idx);
      if (end<0) {
        break;
      }
      builder.add(ItemParserWithRecurse.parse(line.substring(idx + 1, end)));
      idx = end;
    }

    return new Item.List(builder.build());
  }

  private int findNextSeparator(int idx) {
    int nextSepIndex = idx+1;
    int nbOpened = 0;
    while(nextSepIndex<line.length()) {
      final var c = line.charAt(nextSepIndex);
      if (c == ',' && nbOpened == 0) {
        return nextSepIndex;
      }
      else if (c == '[') {
        nbOpened++;
      } else if (c == ']') {
        if (nbOpened == 0) {
          return nextSepIndex;
        }
        nbOpened--;
      }
      nextSepIndex++;
    }
    return -1;
  }


}
