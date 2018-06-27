import React, { Component,PropTypes} from "react";
import {
  requireNativeComponent
} from "react-native";

var myTextView ={
    name:'MyTextViewLOL',
    // propTypes:{
    //     text:PropTypes.string,
    //     textSize:PropTypes.number,
    //     textColor:PropTypes.number,
    // }
}
module.exports =requireNativeComponent('MyTextView',myTextView);
