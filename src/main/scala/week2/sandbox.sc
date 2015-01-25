object Sandbox {

}

val opt: Option[Int]  = None
val some: Option[Int] = Some(1)

opt.flatMap(Some.apply)

opt.flatMap((i) => Some(i * 2))

opt.map((i) => Some(i * 2))

some.flatMap(Some.apply)

some.flatMap((i) => Some(i * 2))
