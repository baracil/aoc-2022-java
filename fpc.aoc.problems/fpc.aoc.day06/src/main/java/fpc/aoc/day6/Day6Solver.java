package fpc.aoc.day6;

import fpc.aoc.day6.struct.School;
import lombok.NonNull;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Stream;

public abstract class Day6Solver extends SmartSolver<School,String> {

    protected static final BigInteger[] GEN_80;
    protected static final BigInteger[] GEN_256;

    static  {
        GEN_80 = Stream.of(1421, 1401, 1191, 1154, 1034, 950, 905, 779, 768).map(BigInteger::valueOf).toArray(BigInteger[]::new);
        GEN_256 = Stream.of(6703087164L, 6206821033L, 5617089148L, 5217223242L, 4726100874L, 4368232009L, 3989468462L, 3649885552L, 3369186778L).map(BigInteger::valueOf).toArray(BigInteger[]::new);
    }

    @Override
    protected @NonNull Converter<School> getConverter() {
        return Converter.FIRST_LINE.andThen(School::parse);
    }
}
