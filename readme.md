# 📝 Algorithm Study Log

[![Solved.ac Profile](http://mazassumnida.wtf/api/v2/generate_badge?boj=joo4123)](https://solved.ac/joo4123)

꾸준히 성장하는 백엔드 개발자의 알고리즘 풀이 저장소입니다.
매일 새로운 문제에 도전하고 효율적인 코드를 고민합니다.

## 🛠️ Automation Tool (Script)

<details>
<summary><b>🖱️ 문제 생성 스크립트 사용법 (클릭해서 보기)</b></summary>
<div markdown="1">

이 저장소는 Python 스크립트를 사용하여 문제 폴더와 파일을 자동으로 생성하고 관리합니다.

### 1. 사용 명령어 (Syntax)

`python create.py [사이트] [문제번호] [문제이름] [난이도] [알고리즘유형]`

### 2. 매개변수 설명 (Parameters)

|   파라미터   | 설명                              | 옵션 (값)                                           |
| :----------: | :-------------------------------- | :-------------------------------------------------- |
|  **사이트**  | 문제 출처 사이트 키               | `boj` (백준), `pgs` (프로그래머스), `swea` (삼성SW) |
| **문제번호** | 해당 문제의 고유 번호             | 예: `14626`, `43165`                                |
| **문제이름** | 문제의 제목 (띄어쓰기는 `_` 권장) | 예: `ISBN`, `타겟넘버`                              |
|  **난이도**  | 문제의 난이도 표기                | 예: `Gold5`, `Lv2`, `D3`                            |
|   **유형**   | 주요 알고리즘 유형                | 예: `DP`, `BFS`, `구현`                             |

### 3. 사용 예시 (Examples)

**백준 (BOJ)**
`python create.py boj 14626 ISBN Bronze1 구현`

**프로그래머스 (Programmers)**
`python create.py pgs 43165 타겟넘버 Lv2 DFS/BFS`

</div>
</details>

<br>
## 🎯 Daily Log

|   날짜   | 사이트 | 문제                                                | 난이도  |    유형    |                 풀이                  |
| :------: | :----: | :-------------------------------------------------- | :-----: | :--------: | :-----------------------------------: |
| 25.11.24 |  BOJ   | [14626_ISBN](https://www.acmicpc.net/problem/14626) | BRONZE1 | 브루트포스 | [Java](./BOJ/2511/24_14626_ISBN.java) |
