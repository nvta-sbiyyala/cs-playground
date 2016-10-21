"use strict";

module.exports = function Text(text) {

  this.highlight = function mark(searchString) {
    return text.replace(new RegExp(searchString, "g"), "<em>" + searchString + "</em>");
  }
};
