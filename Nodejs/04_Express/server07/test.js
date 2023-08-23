function test(x, y, done) {
  const result = done(x, y)
  console.log(`${x} + ${y} = ${result}`)
}

test(10, 20, (a, b) => {
  return a + b
})