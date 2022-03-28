import React, { useContext } from 'react'
import classes from './MediInfo.module.css'
import AddMediInfo from './AddMediInfo';
import MediCartContext from  './../Store/MediCartContext'
import MediInfoModal from './MediInfoModal'
import Button from './../../Commons/Button'

const MediInfo = (props) => {

    const cartContext = useContext(MediCartContext);

    const infoTitle = (
      <ul className={classes.infotitle}>
        약 상세 정보
        <hr /> 
      </ul>
    )
    
    const mediInfomation = (props) => {

      <ul className={classes.infomation}>
        <div>{props.img}</div>
        <h3>이름 : {props.name}</h3>
        {/* <div>업체명 : {props.company}</div> */}
        {/* <div>효능</div> */}
        {/* <div>사용법</div> */}
        {/* <div>주의사항경고</div> */}
        <div>주의사항</div>
        <div>상호작용</div>
        <div>부작용</div>
        <div>보관법</div>
      </ul>
        
      }
      // 이건뭘넣어야하는거지 
    const mediCount = 
    <div className={classes.medicount}>
      <span>`이 약을 복용하고 있는 사람 : ${null}명`</span>
    </div>

    const ModalButton = (
      <div className={classes.exitbutton}>
        <Button onClick={props.onClose}>x</Button>
      </div> 
    )


    // 카드 담기 기능 
    const addItemToCartHandler = (props) => {
      
      // 전체정보 추가해줘야 함 !  
      const mediinfo = {
        id : props.id,
        name : props.name,
        image : props.image,
        
  
      } 
      
      cartContext.addItem(mediinfo);
    }

    const MediInfoContent = (
      <>
      {/* 큰제목 */}
      {infoTitle}
      {/* 닫기버튼*/}
      {ModalButton}
      {/* 이 약을 복용하고 있는 사람 수*/}
      {mediCount}
      {/* 약 상세정보 */}
      {mediInfomation}
      </>
    )


  return (
    
    <MediInfoModal onClose={props.onClose}>
      <MediInfoContent/>
      <AddMediInfo onAddToCart={addItemToCartHandler} />
    </MediInfoModal>
    

  )
}

export default MediInfo