import { Link } from "react-router-dom";
import React, { useState, useCallback } from "react";
import classes from "./BoardRegisterForm.module.css";

export default function BoarderRegisterForm({ onRegister }) {
  const [itemName, setItemName] = useState("");
  const [price, setPrice] = useState(0);
  const [description, setDescription] = useState("");
  const [file, setFile] = useState(null);

  const handleChangeItemName = useCallback((e) => {
    setItemName(e.target.value);
  }, []);

  const handleChangePrice = useCallback((e) => {
    setPrice(e.target.value);
  }, []);

  const handleChangeDescription = useCallback((e) => {
    setDescription(e.target.value);
  }, []);

  const handleChangeFile = useCallback((e) => {
    console.log(e.target.files[0]);
    setFile(e.target.files[0]);
  }, []);

  const handleSubmit = useCallback(
    (e) => {
      e.preventDefault();

      onRegister({ itemName, price, description, file });
    },
    [onRegister, itemName, price, description, file]
  );

  return (
    <div align="center">
      <h2 className={classes.title}>글 작성</h2>
      <h2 className={classes.title2}>
        주의❗ &nbsp; 현재 회원님의 약상자에 담겨 있는 복약 정보가 글과 함께
        보여지게 됩니다.
      </h2>
      <form onSubmit={handleSubmit}>
        <table>
          <tbody>
            <tr>
              <th className={classes.form_label}>사진 등록</th>
              <td>
                <input
                  className={classes.file}
                  type="file"
                  onChange={handleChangeFile}
                />
              </td>
            </tr>
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
          <button type="submit" className="like-a-button success">
            등록
          </button>
          &nbsp;
          <Link to="/medipeople" className="like-a-button">
            취소
          </Link>
        </div>
      </form>
    </div>
  );
}