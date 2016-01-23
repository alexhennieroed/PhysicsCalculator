/**
 * Created by Alexander on 1/23/2016.
 */
public enum GreekLetters {

    ALPHA("α"), DELTA("Δ"), GAMMA("γ"),
    LAMBDA("λ"), MU("μ"), PHI("φ"),
    PI("π"), SIGMA("Σ"), TAU("τ"),
    THETA("θ"), OMEGA("ω");

    private String symbol;

    GreekLetters(String uni) {
        this.symbol = uni;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

}
