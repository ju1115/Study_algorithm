import sys
import os
import datetime
import re

# -----------------------------------------------------
# 1. 설정 (Settings)
# -----------------------------------------------------
FILE_EXTENSION_JAVA = ".java"
FILE_EXTENSION_TXT = ".txt"
README_PATH = "README.md"

# 구분자로 사용할 섹션 제목
SECTION_ANCHOR = "## 🎯 Daily Log"

# [Java 템플릿]
JAVA_TEMPLATE = """import java.util.*;
import java.io.*;

/**
 * 문제: {site} {problem_num} {problem_name}
 * 난이도: {tier}
 * 유형: {algorithm_type}
 */
class Main {{
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {{
        // System.setIn(new FileInputStream("{site}/{year_month}/{day}_{problem_num}_{problem_name}.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }}
}}
"""

SITE_MAP = {
    'boj': 'BOJ',
    'pgs': 'Programmers',
    'swea': 'SWEA'
}

# README 기본 헤더
DEFAULT_HEADER = """# 📝 Algorithm Study Log

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

|   파라미터   | 설명                               | 옵션 (값)                                           |
| :----------: | :-------------------------------- | :-------------------------------------------------- |
|  **사이트** | 문제 출처 사이트 키               | `boj` (백준), `pgs` (프로그래머스), `swea` (삼성SW) |
| **문제번호** | 해당 문제의 고유 번호             | 예: `14626`, `43165`                                |
| **문제이름** | 문제의 제목 (띄어쓰기는 `_` 권장) | 예: `ISBN`, `타겟넘버`                              |
|  **난이도** | 문제의 난이도 표기                | 예: `Gold5`, `Lv2`, `D3`                            |
|    **유형** | 주요 알고리즘 유형                | 예: `DP`, `BFS`, `구현`                             |

</div>
</details>

"""

# -----------------------------------------------------
# 2. URL 생성 로직
# -----------------------------------------------------
def get_problem_url(site_name, problem_num):
    if site_name == 'BOJ':
        return f"https://www.acmicpc.net/problem/{problem_num}"
    elif site_name == 'Programmers':
        return f"https://school.programmers.co.kr/learn/courses/30/lessons/{problem_num}"
    elif site_name == 'SWEA':
        return f"https://swexpertacademy.com/main/code/problem/problemList.do?searchWord={problem_num}"
    return ""

# -----------------------------------------------------
# 3. 메타데이터 파싱 및 README 전체 업데이트 로직
# -----------------------------------------------------
def parse_java_metadata(file_path):
    tier = "Unknown"
    algo_type = "Unknown"
    
    if not os.path.exists(file_path):
        return tier, algo_type

    try:
        with open(file_path, 'r', encoding='utf-8') as f:
            content = f.read()
            tier_match = re.search(r"\*\s*난이도:\s*(.*)", content)
            type_match = re.search(r"\*\s*유형:\s*(.*)", content)
            
            if tier_match: tier = tier_match.group(1).strip()
            if type_match: algo_type = type_match.group(1).strip()
                
    except Exception as e:
        print(f"⚠️ Error parsing {file_path}: {e}")

    return tier, algo_type

def update_all_readme():
    print("🔄 Scanning all directories to update README.md...")
    
    header_content = DEFAULT_HEADER
    if os.path.exists(README_PATH):
        with open(README_PATH, 'r', encoding='utf-8') as f:
            content = f.read()
            if SECTION_ANCHOR in content:
                header_content = content.split(SECTION_ANCHOR)[0]
    
    problems = []

    for site_key, site_folder in SITE_MAP.items():
        if not os.path.exists(site_folder):
            continue
            
        for year_month in os.listdir(site_folder):
            ym_path = os.path.join(site_folder, year_month)
            if not os.path.isdir(ym_path):
                continue
                
            for filename in os.listdir(ym_path):
                if filename.endswith(FILE_EXTENSION_JAVA):
                    parts = filename.replace(FILE_EXTENSION_JAVA, "").split('_', 2)
                    if len(parts) < 3: continue 
                    
                    day = parts[0]
                    problem_num = parts[1]
                    problem_name = parts[2]
                    
                    date_str = f"{year_month[:2]}.{year_month[2:]}.{day}"
                    
                    full_java_path = os.path.join(ym_path, filename)
                    java_rel_path = f"./{site_folder}/{year_month}/{filename}".replace("\\", "/")
                    
                    tier, algo_type = parse_java_metadata(full_java_path)
                    
                    problems.append({
                        "date": date_str,
                        "site": SITE_MAP[site_key],
                        "num": problem_num,
                        "name": problem_name,
                        "tier": tier,
                        "type": algo_type,
                        "java_url": java_rel_path,
                        "raw_date": year_month + day 
                    })

    problems.sort(key=lambda x: x['raw_date'], reverse=True)
    
    with open(README_PATH, 'w', encoding='utf-8') as f:
        f.write(header_content)
        f.write(f"{SECTION_ANCHOR}\n\n")
        f.write("| 날짜 | 사이트 | 문제 | 난이도 | 유형 | 풀이 |\n")
        f.write("| :---: | :---: | :---: | :---: | :---: | :---: |\n")
        
        for p in problems:
            problem_link = get_problem_url(p['site'], p['num'])
            display_name = f"{p['num']}_{p['name']}"
            
            row = f"| {p['date']} | {p['site']} | [{display_name}]({problem_link}) | {p['tier']} | {p['type']} | [Java]({p['java_url']}) |\n"
            f.write(row)
            
    print(f"✅ README.md has been successfully updated with {len(problems)} problems.")

# -----------------------------------------------------
# 4. 메인 로직
# -----------------------------------------------------
def create_problem_file():
    if len(sys.argv) == 2 and sys.argv[1] == '--update':
        update_all_readme()
        return

    if len(sys.argv) < 6:
        print("Usage: python create.py [site] [num] [name] [tier] [type]")
        return

    site_key = sys.argv[1].lower()
    problem_num = sys.argv[2]
    problem_name = sys.argv[3]
    tier = sys.argv[4]
    algo_type = sys.argv[5]

    if site_key not in SITE_MAP:
        print("Error: Invalid site.")
        return

    root_folder = SITE_MAP[site_key]
    
    now = datetime.datetime.now()
    year_month = now.strftime("%y%m")
    day = now.strftime("%d")

    target_dir = os.path.join(root_folder, year_month)
    if not os.path.exists(target_dir):
        os.makedirs(target_dir)

    base_filename = f"{day}_{problem_num}_{problem_name}"

    # 1. Java 파일 생성
    java_path = os.path.join(target_dir, base_filename + FILE_EXTENSION_JAVA)
    if not os.path.exists(java_path):
        content = JAVA_TEMPLATE.format(
            site=SITE_MAP[site_key],
            year_month=year_month,
            day=day,
            problem_num=problem_num,
            problem_name=problem_name,
            tier=tier,
            algorithm_type=algo_type
        )
        with open(java_path, 'w', encoding='utf-8') as f:
            f.write(content)
        print(f"✅ Java Created: {java_path}")
    else:
        print(f"⚠️ Java exists: {java_path}")

    # 2. TXT 파일 생성
    txt_path = os.path.join(target_dir, base_filename + FILE_EXTENSION_TXT)
    if not os.path.exists(txt_path):
        with open(txt_path, 'w', encoding='utf-8') as f:
            f.write("") 
        print(f"✅ Input TXT Created: {txt_path}")
    else:
        print(f"⚠️ TXT exists: {txt_path}")

    # 3. README 전체 업데이트
    update_all_readme()

if __name__ == "__main__":
    create_problem_file()