import streamlit as st
import subprocess
import tempfile
import os

st.set_page_config(page_title="Python Code Editor", layout="wide")

st.title("🧑‍💻 Code Editor")

code = st.text_area("Write your Python code here:", height=300)

if st.button("Run Code"):
    if code.strip() == "":
        st.warning("Please write some code")
    else:
        try:
            with tempfile.NamedTemporaryFile(delete=False, suffix=".py") as tmp:
                tmp.write(code.encode())
                tmp_path = tmp.name

            result = subprocess.run(
                ["python3", tmp_path],
                capture_output=True,
                text=True,
                timeout=5
            )

            st.subheader("Output:")
            if result.stdout:
                st.code(result.stdout, language="text")
            if result.stderr:
                st.error(result.stderr)

        except subprocess.TimeoutExpired:
            st.error("Execution timed out (possible infinite loop)")

        finally:
            if os.path.exists(tmp_path):
                os.remove(tmp_path)