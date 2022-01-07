package week9;

import java.util.*;

public class PRO_49994_방문길이 {

  class Location {
    int x;
    int y;
    int nx;
    int ny;

    Location(int x, int y) {
      this.x = x;
      this.y = y;
    }


  }


  public int solution(String dirs) {
    int answer = 0;
    Location location = new Location(5, 5);
    Set<Location> list = new HashSet<>();
    int N = dirs.length();
    for (int i = 0; i < N; i++) {
      int nx = 0;
      int ny = 0;
      switch (dirs.charAt(i)) {
        case 'U':
          nx = location.x - 1;
          ny = location.y;
          break;
        case 'D':
          nx = location.x + 1;
          ny = location.y;
          break;
        case 'R':
          nx = location.x;
          ny = location.y + 1;
          break;
        case 'L':
          nx = location.x;
          ny = location.y - 1;
          break;
      }
      if (nx >= 11 || nx < 0 || ny >= 11 || ny < 0) continue;
      // x, y를 찾으면 된다. nx ny로
      Location loc = new Location(location.x, location.y);
      loc.nx = nx;
      loc.ny = ny;
      boolean boo = false;
      for (Location l : list) {
        if ((l.x == loc.nx && l.y == loc.ny && l.nx == loc.x && l.ny == loc.y) ||
                (l.nx == loc.nx && l.ny == loc.ny && l.x == loc.x && l.y == loc.y) ) {
          boo = true;
          break;
        }
      }
      if (!boo) list.add(loc);
      location.x = nx;
      location.y = ny;
    }

    return list.size();
  }


  public static void main(String[] args) {
    System.out.println(new PRO_49994_방문길이().solution("ULURRDLLU"));
  }
}
