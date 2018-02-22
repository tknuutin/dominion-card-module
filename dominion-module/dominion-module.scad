difference () {
  difference () {
    cube ([69, 15, 45], center=true);
    union () {
      union () {
        translate ([0, 7/2, 69/2]) {
          cube ([62, 9, 96], center=true);
        }
        translate ([0, 7/2, 45/4]) {
          cube ([70, 9, 45/2], center=true);
        }
      }
      translate ([0, 7/2, 0]) {
        cube ([80/3, 9, 45], center=true);
      }
    }
  }
  translate ([0, 0, 45/2]) {
    cube ([40, 69, 60], center=true);
  }
}
