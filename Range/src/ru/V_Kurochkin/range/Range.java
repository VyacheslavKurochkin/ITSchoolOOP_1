package ru.V_Kurochkin.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && to >= number;
    }

    public Range getIntersection(Range range) {

        if (this.to > range.getFrom() && this.from < range.getTo()) {
            if (range.getFrom() > this.from && range.getTo() < this.to) {
                return new Range(range.getFrom(), range.getTo());
            }

            if (range.getFrom() <= this.from && range.getTo() >= this.to) {
                return new Range(this.from, this.to);
            }

            if (this.from > range.getTo() && range.getTo() < this.to) {
                return new Range(this.from, range.getTo());
            }

            return new Range(range.getFrom(), this.to);
        }

        return null;
    }

    public Range[] getUnion(Range range) {

        if (this.to >= range.getFrom() && this.from <= range.getTo()) {
            double newRangeFrom = (this.from < range.getFrom()) ? this.from : range.getFrom();
            double newRangeTo = (this.to > range.getTo()) ? this.to : range.getTo();

            return new Range[]{new Range(newRangeFrom, newRangeTo)};
        }

        return new Range[]{new Range(this.from, this.to), new Range(range.getFrom(), range.getTo())};
    }

    public Range[] getSubtraction(Range range) {

        if (this.to > range.getFrom() && this.from < range.getTo()) {
            if (range.getFrom() > this.from && range.getTo() < this.to) {
                return new Range[]{new Range(this.from, range.getFrom()), new Range(range.getTo(), this.to)};
            }

            if (range.getFrom() <= this.from && range.getTo() >= this.to) {
                return null;
            }

            if (this.from > range.getTo() && range.getTo() < this.to) {
                return new Range[]{new Range(range.getTo(), this.to)};
            }

            return new Range[]{new Range(this.from, range.getFrom())};
        }

        return new Range[]{new Range(this.from, this.to)};
    }
}

