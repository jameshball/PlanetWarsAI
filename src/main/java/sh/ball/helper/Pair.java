package sh.ball.helper;

import java.util.Map;
import java.util.Objects;

public class Pair<S, T> implements Map.Entry<S, T> {
  private final S key;
  private T value;

  public Pair(S key, T value) {
    this.key = key;
    this.value = value;
  }

  @Override
  public S getKey() {
    return key;
  }

  @Override
  public T getValue() {
    return value;
  }

  @Override
  public T setValue(T value) {
    return this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pair<?, ?> pair = (Pair<?, ?>) o;
    return Objects.equals(key, pair.key) &&
        Objects.equals(value, pair.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, value);
  }
}
