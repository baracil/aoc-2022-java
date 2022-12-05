package fpc.aoc.day5;

import com.google.common.collect.ImmutableList;
import fpc.aoc.common.AOCException;
import lombok.NonNull;
import lombok.Value;

import java.util.function.Consumer;
import java.util.stream.Collector;

@Value
public class Input5 {

  @NonNull Stacks stacks;
  @NonNull ImmutableList<ProcedureStep> steps;


  public static final Collector<String, ?, Input5> COLLECTOR = Collector.of(
      Agg::new, Agg::add, Agg::combine, Agg::builder
  );


  private static class Agg {

    private final ImmutableList.Builder<String> headerBuilder = ImmutableList.builder();
    private final ImmutableList.Builder<ProcedureStep> stepsBuilder = ImmutableList.builder();

    private Consumer<String> consumer = this::addHeaderLine;

    public void add(@NonNull String line) {
      if (line.isBlank()) {
        consumer = this::addProcedureStep;
      } else {
        consumer.accept(line);
      }
    }

    public @NonNull Agg combine(@NonNull Agg agg) {
      throw new AOCException("Cannot combine");
    }

    public @NonNull Input5 builder() {
      return new Input5(Stacks.parse(headerBuilder.build()), stepsBuilder.build());
    }

    public void addHeaderLine(@NonNull String line) {
      headerBuilder.add(line);
    }

    public void addProcedureStep(@NonNull String line) {
      stepsBuilder.add(ProcedureStep.parse(line));
    }
  }
}
