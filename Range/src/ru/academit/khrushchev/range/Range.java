package ru.academit.khrushchev.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return this.from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return this.to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public Range getCross(Range range) {
        if (from < range.to && to > range.from) {
            return new Range(Math.max(range.from, from), Math.min(range.to, to));
        }

        return null;
    }

    public Range[] getUnion(Range range) {
        if (to < range.from || from > range.to) {
            return new Range[]{new Range(range.from, range.to), new Range(from, to)};
        }

        return new Range[]{new Range(Math.min(from, range.from), Math.max(to, range.to))};
    }

    public Range[] getSubtraction(Range range) {
        if (from >= range.from && to <= range.to) {
            return new Range[]{};
        }

        if (to < range.from || from > range.to) {
            return new Range[]{new Range(from, to)};
        }

        if (from < range.from && to >= range.from && to <= range.to) {
            return new Range[]{new Range(from, range.from)};
        }

        if (from <= range.to && to > range.to && from >= range.from) {
            return new Range[]{new Range(range.to, to)};
        }

        return new Range[]{new Range(from, range.from), new Range(range.to, to)};
    }
}