difference () {
  difference () {
    difference () {
      union () {
        cube ([69, 15, 45], center=true);
        union () {
          translate ([175/6, 15/2, 0]) {
            rotate ([0.0,0.0,90.0]) {
              translate ([44/15, 0, -18.7]) {
                union () {
                  translate ([16/5, 0, 0]) {
                    cylinder (h=7.6, r=8/3, center=true);
                  }
                  cube ([31/5, 8/5, 7.6], center=true);
                }
              }
            }
          }
          translate ([-175/6, 15/2, 0]) {
            rotate ([0.0,0.0,90.0]) {
              translate ([44/15, 0, -18.7]) {
                union () {
                  translate ([16/5, 0, 0]) {
                    cylinder (h=7.6, r=8/3, center=true);
                  }
                  cube ([31/5, 8/5, 7.6], center=true);
                }
              }
            }
          }
        }
      }
      translate ([0, -15, -1.0E-4]) {
        union () {
          translate ([175/6, 15/2, 0]) {
            rotate ([0.0,0.0,90.0]) {
              translate ([3.0266666666666673, 0, -18.434]) {
                union () {
                  translate ([16/5, 0, 0]) {
                    cylinder (h=8.132, r=2.853333333333334, center=true);
                  }
                  cube ([6.634, 8/5, 8.132], center=true);
                }
              }
            }
          }
          translate ([-175/6, 15/2, 0]) {
            rotate ([0.0,0.0,90.0]) {
              translate ([3.0266666666666673, 0, -18.434]) {
                union () {
                  translate ([16/5, 0, 0]) {
                    cylinder (h=8.132, r=2.853333333333334, center=true);
                  }
                  cube ([6.634, 8/5, 8.132], center=true);
                }
              }
            }
          }
        }
      }
    }
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
