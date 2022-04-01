import { Link } from "react-router-dom";
import React, { useState, useCallback } from "react";
import classes from "./BoardMore.module.css";

export default function BoarderMore({ onRegister }) {
  const [description, setDescription] = useState("");
  const [file, setFile] = useState(null);

  const handleChangeDescription = useCallback((e) => {
    setDescription(e.target.value);
  }, []);

  const handleChangeFile = useCallback((e) => {
    console.log(e.target.files[0]);
    setFile(e.target.files[0]);
  }, []);

  const handleSubmit = useCallback((e) => {
    e.preventDefault();
    onRegister({ description, file });
  });

  return (
    <div align="center">
      <h2 className={classes.title}>상세보기 화면</h2>
      <h2 className={classes.title2}>
        주의❗ &nbsp; 현재 회원님의 약상자에 담겨 있는 복약 정보가 글과 함께
        보여지게 됩니다.
      </h2>
      <form onSubmit={handleSubmit}>
        <table>
          <tbody>
            <tr>
              <th className={classes.form_label}>내용</th>
              <td>
                <textarea
                  className={classes.textarea}
                  rows="5"
                  value={description}
                  onChange={handleChangeDescription}
                />
              </td>
            </tr>
          </tbody>
        </table>

        <div>
          <button type="submit" className={classes.like_a_button}>
            <Link to="/medipeople" className="like-a-button">
              목록으로
            </Link>
          </button>
        </div>
      </form>
    </div>
  );
}
