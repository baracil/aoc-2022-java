package fpc.aoc.input;

import com.google.common.collect.ImmutableList;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import fpc.aoc.api.AOCProblem;
import fpc.aoc.api.Day;
import fpc.aoc.api.Part;
import fpc.aoc.api.Solver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

@RequiredArgsConstructor
public abstract class SmartSolver<I,S> implements Solver<I,S> {

    private static final Pattern DAY_PART = Pattern.compile("Day(?<day>[0-9]+)Part(?<part>[12]).+");

    @Getter
    private final @NonNull Day day;
    @Getter
    private final @NonNull Part part;

    public SmartSolver() {
        final Matcher matcher = DAY_PART.matcher(this.getClass().getSimpleName());
        if (!matcher.matches()) {
            throw new RuntimeException("Solver must provide DAY and PART by parameter or by having its name of the form DayXXParY");
        }
        this.day = Day.parse(matcher.group("day"));
        this.part = Part.parse(matcher.group("part"));
    }

    /**
     * @return the converter required to convert the input data of the problem to the required type
     */
    protected abstract @NonNull Converter<I> getConverter();


    /**
     * @return an {@link AOCProblem} using this solver and the resources associated as input
     */
    public @NonNull AOCProblem<S> createProblem() {
        return AOCProblemUsingSolver.create(this, this.getConverter());
    }

    /**
     * @return an {@link AOCProblem} using this solver and the provided lines as input
     */
    public @NonNull AOCProblem<S> createProblem(@NonNull ImmutableList<String> lines) {
        return AOCProblemUsingSolver.create(this, new ListOfLines(lines), this.getConverter());
    }

    /**
     * @return an {@link AOCProblem} using this solver and the provided multi lines as input
     */
    public @NonNull AOCProblem<S> createProblem(@NonNull String multiLines) {
        return AOCProblemUsingSolver.create(this, new MultiLines(multiLines), this.getConverter());
    }

    /**
     * @return an {@link AOCProblem} using this solver and the provided multi lines as input
     */
    public @NonNull AOCProblem<S> createProblem(@NonNull Input<Stream<String>> input) {
        return AOCProblemUsingSolver.create(this, input, this.getConverter());
    }


}
