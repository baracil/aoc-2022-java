package fpc.aoc.day5;

import lombok.NonNull;

public interface CrateMover {

  void performProcedureStep(@NonNull Stacks stacks, @NonNull ProcedureStep procedureStep);

}
