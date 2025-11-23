package lib

import circle.Circle

extension (c: Circle)
  def circumreference: Double = c.radius * math.Pi * 2
  def diameter: Double = c.radius * 2
  def area: Double = math.Pi * c.radius * c.radius
