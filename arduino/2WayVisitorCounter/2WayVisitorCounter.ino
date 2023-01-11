

int count = 0;

long readUltrasonicDistance(int triggerPin, int echoPin)
{
  pinMode(triggerPin, OUTPUT);  // Clear the trigger
  digitalWrite(triggerPin, LOW);
  delayMicroseconds(2);
  // Sets the trigger pin to HIGH state for 10 microseconds
  digitalWrite(triggerPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(triggerPin, LOW);
  pinMode(echoPin, INPUT);
  // Reads the echo pin, and returns the sound wave travel time in microseconds
  return pulseIn(echoPin, HIGH);
}

void setup()
{
  Serial.begin(9600);
}

void loop()
{
  if (0.01723 * readUltrasonicDistance(6, 5) < 10) {
    count = (count + 1);
    Serial.print("Number of people inside : ");
    Serial.println(count);
  }
  if (0.01723 * readUltrasonicDistance(11, 10) < 10) {
    count = (count - 1);
    Serial.print("Number of people inside : ");
    Serial.println(count);
  }
  delay(600); // Wait for 600 millisecond(s)
}