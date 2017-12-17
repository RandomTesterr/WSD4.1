package ontology;

import jade.content.Concept;

import java.util.Objects;

public class SignParameters implements Concept {
    Long _x;
    Long _y_begin;
    Long _y_end;
    Long _limit_max_speed;

    public SignParameters() {
        this._x = 1L;
        this._y_begin = 0L;
        this._y_end = 50L;
        this._limit_max_speed = 150L;
    }

    public SignParameters(Long y_start, Long y_end, Long _max_speed) {
        this._x = 1L;
        this._y_begin = y_start;
        this._y_end = y_end;
        this._limit_max_speed = _max_speed;
    }

    public Long getX() {
        return _x;
    }

    public void setX(Long _x) {
        this._x = _x;
    }

    public Long getY_begin() {
        return _y_begin;
    }

    public void setY_begin(Long _y_start) {
        this._y_begin = _y_start;
    }

    public Long getY_end() {
        return _y_end;
    }

    public void setY_end(Long _y_end) {
        this._y_end = _y_end;
    }

    public Long getLimit_max_speed() {
        return _limit_max_speed;
    }

    public void setLimit_max_speed(Long _max_speed) {
        this._limit_max_speed = _max_speed;
    }
}
