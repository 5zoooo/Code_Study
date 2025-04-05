letter_values = {
    'A': 3, 'B': 2, 'C': 1, 'D': 2, 'E': 3, 'F': 3, 'G': 3,
    'H': 1, 'I': 1, 'J': 3, 'K': 1, 'L': 3, 'M': 1, 'N': 3,
    'O': 1, 'P': 2, 'Q': 2, 'R': 2, 'S': 1, 'T': 2, 'U': 1,
    'V': 1, 'W': 2, 'X': 2, 'Y': 2, 'Z': 1
}

k = input()
val = 0

for ch in k :
    val += letter_values[ch]

final = val % 10

if final% 2 == 0 :
    print("You're the winner?")
else :
    print("I'm a winner!")
