package dtm.ide.api.extension.runconfig;

import lombok.Getter;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BooleanSupplier;
import java.util.function.LongSupplier;

public final class RunProcessHandle {

    public enum StdinMode {
        NONE,
        @Deprecated FIELD,
        TERMINAL
    }

    @FunctionalInterface
    public interface Resizer {
        void resize(int columns, int rows);
    }

    @Getter
    private final InputStream output;

    @Getter
    private final OutputStream input;

    @Getter
    private final BooleanSupplier alive;

    @Getter
    private final Runnable terminate;

    @Getter
    private final boolean readonly;

    @Getter
    private final StdinMode stdinMode;

    @Getter
    private final boolean ptyBacked;

    private final LongSupplier processPidSupplier;

    private final Resizer resizer;

    private RunProcessHandle(
            InputStream output,
            OutputStream input,
            BooleanSupplier alive,
            Runnable terminate,
            boolean readonly,
            StdinMode stdinMode,
            boolean ptyBacked,
            LongSupplier processPidSupplier
    ) {
        this(output, input, alive, terminate, readonly, stdinMode, ptyBacked, processPidSupplier, null);
    }

    private RunProcessHandle(
            InputStream output,
            OutputStream input,
            BooleanSupplier alive,
            Runnable terminate,
            boolean readonly,
            StdinMode stdinMode,
            boolean ptyBacked,
            LongSupplier processPidSupplier,
            Resizer resizer
    ) {
        this.resizer = resizer;
        this.output = output == null ? InputStream.nullInputStream() : output;
        this.input = input;
        this.alive = alive != null ? alive : () -> false;
        this.terminate = terminate != null ? terminate : () -> {};
        this.readonly = readonly;
        this.stdinMode = stdinMode != null ? stdinMode : (readonly ? StdinMode.NONE : StdinMode.TERMINAL);
        this.ptyBacked = ptyBacked;
        this.processPidSupplier = processPidSupplier != null ? processPidSupplier : () -> 0L;
    }

    public boolean isAlive() {
        return alive.getAsBoolean();
    }

    public void terminate() {
        terminate.run();
    }

    public boolean isResizable() {
        return resizer != null;
    }

    public void resize(int columns, int rows) {
        if (resizer == null || columns <= 0 || rows <= 0) {
            return;
        }
        resizer.resize(columns, rows);
    }

    public long getProcessPid() {
        return processPidSupplier.getAsLong();
    }

    public LongSupplier getProcessPidSupplier() {
        return processPidSupplier;
    }

    public static RunProcessHandle empty() {
        return new RunProcessHandle(
                null,
                null,
                null,
                null,
                true,
                StdinMode.NONE,
                false,
                null
        );
    }

    public static RunProcessHandle outputOnly(InputStream output) {
        return new RunProcessHandle(
                output,
                null,
                null,
                null,
                true,
                StdinMode.NONE,
                false,
                null
        );
    }

    public static RunProcessHandle interactive(InputStream output, OutputStream input) {
        Objects.requireNonNull(input, "input");

        return new RunProcessHandle(
                output,
                input,
                null,
                null,
                false,
                StdinMode.TERMINAL,
                false,
                null
        );
    }

    public static RunProcessHandle fieldInput(InputStream output, OutputStream input) {
        Objects.requireNonNull(input, "input");

        return new RunProcessHandle(
                output,
                input,
                null,
                null,
                false,
                StdinMode.FIELD,
                false,
                null
        );
    }

    public static RunProcessHandle fieldInput(Process process) {
        Objects.requireNonNull(process, "process");

        return new RunProcessHandle(
                process.getInputStream(),
                process.getOutputStream(),
                process::isAlive,
                process::destroy,
                false,
                StdinMode.FIELD,
                false,
                process::pid
        );
    }

    public static RunProcessHandle ofProcess(Process process) {
        Objects.requireNonNull(process, "process");

        return new RunProcessHandle(
                process.getInputStream(),
                process.getOutputStream(),
                process::isAlive,
                process::destroy,
                false,
                StdinMode.TERMINAL,
                false,
                process::pid
        );
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private InputStream output;
        private OutputStream input;
        private BooleanSupplier alive;
        private Runnable terminate;
        private Boolean readonly;
        private StdinMode stdinMode;
        private boolean ptyBacked;
        private LongSupplier processPidSupplier;
        private Resizer resizer;

        public Builder output(InputStream stream) {
            this.output = stream;
            return this;
        }

        public Builder input(OutputStream stream) {
            this.input = stream;
            return this;
        }

        public Builder alive(BooleanSupplier supplier) {
            this.alive = supplier;
            return this;
        }

        public Builder terminate(Runnable runnable) {
            this.terminate = runnable;
            return this;
        }

        public Builder readonly(boolean value) {
            this.readonly = value;
            return this;
        }

        public Builder stdinMode(StdinMode mode) {
            this.stdinMode = mode;
            return this;
        }

        public Builder ptyBacked(boolean value) {
            this.ptyBacked = value;
            return this;
        }

        public Builder resizer(Resizer resizer) {
            this.resizer = resizer;
            return this;
        }

        public Builder processPid(long processPid) {
            this.processPidSupplier = () -> processPid;
            return this;
        }

        public Builder processPid(AtomicLong processPid) {
            Objects.requireNonNull(processPid, "processPid");
            this.processPidSupplier = processPid::get;
            return this;
        }

        public Builder processPid(LongSupplier processPidSupplier) {
            this.processPidSupplier = Objects.requireNonNull(processPidSupplier, "processPidSupplier");
            return this;
        }

        public Builder process(Process process) {
            Objects.requireNonNull(process, "process");

            this.output = process.getInputStream();
            this.input = process.getOutputStream();
            this.alive = process::isAlive;
            this.terminate = process::destroy;
            this.processPidSupplier = process::pid;

            return this;
        }

        public RunProcessHandle build() {
            boolean effectiveReadonly = readonly != null ? readonly : input == null;

            return new RunProcessHandle(
                    output,
                    input,
                    alive,
                    terminate,
                    effectiveReadonly,
                    stdinMode,
                    ptyBacked,
                    processPidSupplier,
                    resizer
            );
        }
    }
}