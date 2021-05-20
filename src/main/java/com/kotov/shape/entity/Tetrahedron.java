package com.kotov.shape.entity;

import com.kotov.shape.exception.TetrahedronException;
import com.kotov.shape.observer.TetrahedronObservable;
import com.kotov.shape.observer.TetrahedronObserver;
import com.kotov.shape.observer.TetrahedronEvent;
import com.kotov.shape.util.ShapeIdGeneration;

public class Tetrahedron implements TetrahedronObservable {
    private final long tetrahedronId;
    private TetrahedronObserver observer;
    private Point a;
    private Point b;
    private Point c;
    private Point d;

    {
        tetrahedronId = ShapeIdGeneration.generateId();
    }

    public Tetrahedron(Point a, Point b, Point c, Point d) throws TetrahedronException {
        if (a == null || b == null || c == null || d == null) {
            throw new TetrahedronException("Unable to create Tetrahedron object. Argument(s) contains null");
        }
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public void setA(Point a) throws TetrahedronException {
        if (a == null) {
            throw new TetrahedronException("Unable to change Point a in Tetrahedron object. Argument contains null");
        }
        this.a = a;
        notifyObserver();
    }

    public void setB(Point b) throws TetrahedronException {
        if (b == null) {
            throw new TetrahedronException("Unable to change Point b in Tetrahedron object. Argument contains null");
        }
        this.b = b;
        notifyObserver();
    }

    public void setC(Point c) throws TetrahedronException {
        if (c == null) {
            throw new TetrahedronException("Unable to change Point c in Tetrahedron object. Argument contains null");
        }
        this.c = c;
        notifyObserver();
    }

    public void setD(Point d) throws TetrahedronException {
        if (d == null) {
            throw new TetrahedronException("Unable to change Point d in Tetrahedron object. Argument contains null");
        }
        this.d = d;
        notifyObserver();
    }

    public long getTetrahedronId() {
        return tetrahedronId;
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }

    public Point getD() {
        return d;
    }

    @Override
    public void attach(TetrahedronObserver observer) {
        this.observer = observer;
    }

    @Override
    public void detach() {
        observer = null;
    }

    @Override
    public void notifyObserver() {
        if (observer != null) {
            TetrahedronEvent event = new TetrahedronEvent(this);
            observer.parametersChanged(event);
        }
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }

        Tetrahedron other = (Tetrahedron) otherObject;

        if (tetrahedronId != other.tetrahedronId) {
            return false;
        }
        if (a == null) {
            if (other.a != null) {
                return false;
            }
        } else if (!a.equals(other.a)) {
            return false;
        }
        if (b == null) {
            if (other.b != null) {
                return false;
            }
        } else if (!b.equals(other.b)) {
            return false;
        }
        if (c == null) {
            if (other.c != null) {
                return false;
            }
        } else if (!c.equals(other.c)) {
            return false;
        }
        if (d == null) {
            return other.d == null;
        }
        return d.equals(other.d);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Long.hashCode(tetrahedronId);
        result = prime * result + ((a == null) ? 0 : a.hashCode());
        result = prime * result + ((b == null) ? 0 : b.hashCode());
        result = prime * result + ((c == null) ? 0 : c.hashCode());
        result = prime * result + ((d == null) ? 0 : d.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(getClass().getSimpleName());
        result.append(" [ pyramidID = ").append(tetrahedronId);
        result.append(", a = ").append(a);
        result.append(", b = ").append(b);
        result.append(", c = ").append(c);
        result.append(", d = ").append(d);
        result.append(" ]");
        return result.toString();
    }
}