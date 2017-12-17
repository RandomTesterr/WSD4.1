package ontology;

import jade.content.Concept;

import java.util.Objects;

public class VehicleParameters implements Concept {
    Long  _x;
    Long _y;
    Long  _speed;
    Long _max_speed;
    Long _acceleration;
    Long _max_speed_of_sign;

    public VehicleParameters(){
        this._x = 1L;
        this._y = 0L;
        this._speed = 50L;
        this._max_speed = 150L;
        this._acceleration=0L;
        this._max_speed_of_sign=150L;
    }

    public VehicleParameters(Long speed, Long maxSpeed, Long x){
        this._x = x;
        this._y = 0L;
        this._speed = speed;
        this._max_speed = maxSpeed;
        this._acceleration=0L;
        this._max_speed_of_sign=maxSpeed;
    }
//nowe
    public Long get_max_speed_of_sign() {
        return  _max_speed_of_sign;
    }
    public void set_max_speed_of_sign(Long max_speed_of_sign ) {
        this._max_speed_of_sign=max_speed_of_sign;
    }
//
    public Long getX() {
        return _x;
    }

    public void setX(Long x) {
        this._x = x;
    }

    public void addY(Long y){
        _y += y;
    }

    public void addSpeed(Long speed){
        _speed += speed;
    }

    public void updateSpeed(){
        _speed += _acceleration;
    }

    public void updateY(Long interval){
        _y += _speed/interval;
    }

//    public void setPercentageAcceler(Long percent){
//        if(_speed == 0L){
//            _speed += _max_speed*2/10;
//        }
//        _acceleration = _speed*percent/100;
//    }
    //
    public void setPercentageAcceler(Long percent){
        if(_speed == 0L){
            _speed += getMax_speed()*2/10;
        }
        _acceleration = _speed*percent/100;
    }
    //
    public void addAcceleration(Long acc){
        _acceleration +=acc;
    }

//    public void addPercentageAcceleration(Long percent){
//        if(_speed == 0L){
//            _speed += _max_speed*2/10;
//        }
//        _acceleration += _speed*percent/100;
//    }
    //
    public void addPercentageAcceleration(Long percent){
        if(_speed == 0L){
            _speed += getMax_speed()*2/10;
        }
        _acceleration += _speed*percent/100;
    }
    //
    public Long getY() {
        return _y;
    }

    public void setY(Long y) {
        this._y = y;
    }

    public Long getSpeed() {
        return _speed;
    }

    public void setSpeed(Long speed) {
        this._speed = speed;
    }

//    public Long getMax_speed() {
//        return _max_speed;
//    }
    //nowe
    public Long getMax_speed() {
        if(_max_speed>_max_speed_of_sign) {
            return _max_speed_of_sign;
        }
        else {
            return _max_speed;
        }
}
    //

    public void setMax_speed(Long max_speed) {
        this._max_speed = max_speed;
    }

    public Long getAcceleration() {
        return _acceleration;
    }

    public void setAcceleration(Long _acceleration) {
        this._acceleration = _acceleration;
    }

    public boolean equals(VehicleParameters obj) {
        return (Objects.equals(obj._y, this._y) &&
                Objects.equals(obj._x, this._x) &&
                Objects.equals(obj._max_speed, this._max_speed) &&
                Objects.equals(obj._speed, this._speed) &&
                Objects.equals(obj._acceleration, this._acceleration));
    }
}
