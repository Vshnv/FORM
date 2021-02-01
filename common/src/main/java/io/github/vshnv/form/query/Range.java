package io.github.vshnv.form.query;

public final class Range<T extends Number> {
    private final T start;
    private final T end;

    public Range(T start, T end) {
        this.start = start;
        this.end = end;
    }

    public T getStart() {
        return start;
    }

    public T getEnd() {
        return end;
    }

    public <U extends Number> boolean includes(U value) {
        return start.doubleValue() < value.doubleValue() && value.doubleValue() < end.doubleValue();
    }
}
