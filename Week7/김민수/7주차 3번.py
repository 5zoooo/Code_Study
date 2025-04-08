# 7주차 3번

text = input()

def reverse_words_with_tags(text):
    result = []
    word = ''
    inside_tag = False

    for ch in text:
        if ch == '<':
            if word:
                result.append(word[::-1])
                word = ''
            inside_tag = True
            result.append(ch)

        elif ch == '>':
            inside_tag = False
            result.append(ch)

        elif inside_tag:
            result.append(ch)

        elif ch == ' ':
            if word:
                result.append(word[::-1])  
                word = ''
            result.append(' ')  

        else:
            word += ch  

    if word:
        result.append(word[::-1])

    return ''.join(result)

print(reverse_words_with_tags(text))

