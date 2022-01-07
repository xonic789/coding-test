package week9;

import java.util.*;

public class PRO_49994_방문길이 {

  class Location {
    int x;
    int y;
    int nx;
    int ny;

    Location(int x, int y, int nx, int ny) {
      this.x = x;
      this.y = y;
      this.nx = nx;
      this.ny = ny;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Location location = (Location) o;
      return (x == location.x && y == location.y && nx == location.nx && ny == location.ny) || (x == location.nx && y == location.ny && ny == location.y && nx == location.x);
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y, nx, ny);
    }
  }


  public int solution(String dirs) {
    int answer = 0;
    Location location = new Location(5, 5, 0, 0);
    List<Location> list = new ArrayList<>();
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
      Location loc = new Location(location.x, location.y, nx, ny);
      boolean isEquals = false;
      for (Location tmp : list) {
        if (tmp.equals(loc)) isEquals = true;
      }
      if (!isEquals) list.add(loc);
      location.x = nx;
      location.y = ny;
    }

    return set.size();
  }


  public static void main(String[] args) {
    System.out.println(new PRO_49994_방문길이().solution("ULURRDLLU"));
  }
}
