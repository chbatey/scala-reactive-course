val f: PartialFunction[List[Int], String] = {
  case Nil => "one"
  case x :: y :: rest => "two"
}

f.isDefinedAt(List(1))

for (
  i <- 1 to 5;
  j <- 1 to 5
  if i % 2 == 0
) yield i * j