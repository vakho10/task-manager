package ge.edu.sangu.tasklist.service;

import javafx.beans.property.*;

import java.util.Objects;

public final class Process {
    private StringProperty imageName = new SimpleStringProperty(this, "imageName");
    private IntegerProperty pid = new SimpleIntegerProperty(this, "pid");
    private StringProperty sessionName = new SimpleStringProperty(this, "sessionName");
    private IntegerProperty sessionIdentifier = new SimpleIntegerProperty(this, "sessionIdentifier");
    private LongProperty memoryUsage = new SimpleLongProperty(this, "memoryUsage");

    public Process(String imageName,
                   int pid,
                   String sessionName,
                   int sessionIdentifier,
                   long memoryUsage) {
        setImageName(imageName);
        setPid(pid);
        setSessionName(sessionName);
        setSessionIdentifier(sessionIdentifier);
        setMemoryUsage(memoryUsage);
    }

    public String getImageName() {
        return imageName.get();
    }

    public StringProperty imageNameProperty() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName.set(imageName);
    }

    public int getPid() {
        return pid.get();
    }

    public IntegerProperty pidProperty() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid.set(pid);
    }

    public String getSessionName() {
        return sessionName.get();
    }

    public StringProperty sessionNameProperty() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName.set(sessionName);
    }

    public int getSessionIdentifier() {
        return sessionIdentifier.get();
    }

    public IntegerProperty sessionIdentifierProperty() {
        return sessionIdentifier;
    }

    public void setSessionIdentifier(int sessionIdentifier) {
        this.sessionIdentifier.set(sessionIdentifier);
    }

    public long getMemoryUsage() {
        return memoryUsage.get();
    }

    public LongProperty memoryUsageProperty() {
        return memoryUsage;
    }

    public void setMemoryUsage(long memoryUsage) {
        this.memoryUsage.set(memoryUsage);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Process process = (Process) o;
        return Objects.equals(imageName, process.imageName) && Objects.equals(pid, process.pid) && Objects.equals(sessionName, process.sessionName) && Objects.equals(sessionIdentifier, process.sessionIdentifier) && Objects.equals(memoryUsage, process.memoryUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageName, pid, sessionName, sessionIdentifier, memoryUsage);
    }

    @Override
    public String toString() {
        return "Process{" +
                "imageName=" + imageName +
                ", pid=" + pid +
                ", sessionName=" + sessionName +
                ", sessionIdentifier=" + sessionIdentifier +
                ", memoryUsage=" + memoryUsage +
                '}';
    }
}
