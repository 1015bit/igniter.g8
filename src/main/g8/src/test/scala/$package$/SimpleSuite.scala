package $package$

import minitest.SimpleTestSuite

object SimpleSuite extends SimpleTestSuite {

  test("writing tests with minitest") {
    assertEquals(2, 1 + 1)
  }

}